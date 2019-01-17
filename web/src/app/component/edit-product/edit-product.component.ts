import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {FormControl, Validators} from '@angular/forms';
import {AppErrorStateMatcher} from '../../util/app-error-state-matcher';
import {Brand} from '../../model/brand';
import {Section} from '../../model/section';
import {BrandService} from '../../service/brand.service';
import {SectionService} from '../../service/section.service';
import {MessageService} from '../../service/message.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  idProductFormControl: FormControl;
  productNameFormControl: FormControl;
  productPriceFormControl: FormControl;
  matcher: AppErrorStateMatcher;

  product: Product;
  brands: Brand[];
  sections: Section[];

  constructor(private route: ActivatedRoute,
              private productService: ProductService,
              private brandService: BrandService,
              private sectionService: SectionService,
              private router: Router,
              private location: Location,
              private messageService: MessageService) { }

  ngOnInit() {
    this.setProduct();
    this.initBrands();
    this.initSections();
    this.createFormControls();
    this.matcher = new AppErrorStateMatcher();
  }

  isFormValid() {
    return this.idProductFormControl.valid &&
      this.productNameFormControl.valid &&
      this.productPriceFormControl.valid;
  }

  onBrandChange(value) {
    const selectedBrand = this.brands.filter(brand => {
      return brand.brandName === value;
    });
    this.product.brand = selectedBrand[0];
  }

  onSectionChange(value) {
    const selectedSection = this.sections.filter(section => {
      return section.sectionName === value;
    });
    this.product.section = selectedSection[0];
  }

  update() {
    this.productService.update(this.product).subscribe(data => {
      this.product = data;
      this.messageService.success('Edycja produktu zakończona pomyślnie', 5000);
      this.router.navigate(['/products']);
    });
  }

  back() {
    this.location.back();
  }

  private setProduct() {
    const id = this.route.snapshot.paramMap.get('id');
    this.productService.getById(id).subscribe(data => {
      this.product = data;
    }, error => {
      this.router.navigate(['/error']);
    });
  }

  private initBrands() {
    this.brandService.getAll().subscribe(data => {
      this.brands = data;
    });
  }

  private initSections() {
    this.sectionService.getAll().subscribe(data => {
      this.sections = data;
    });
  }

  private createFormControls() {
    this.idProductFormControl = new FormControl('', [
      Validators.required,
      Validators.pattern('[0-9]+')
    ]);
    this.productNameFormControl = new FormControl('', [
      Validators.required
    ]);
    this.productPriceFormControl = new FormControl('', [
      Validators.required,
      Validators.pattern('[0-9]+.[0-9]{2}')
    ]);
  }

}
