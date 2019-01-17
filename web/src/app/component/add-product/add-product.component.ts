import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {AppErrorStateMatcher} from '../../util/app-error-state-matcher';
import {Product} from '../../model/product';
import {Brand} from '../../model/brand';
import {Section} from '../../model/section';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {BrandService} from '../../service/brand.service';
import {SectionService} from '../../service/section.service';
import {Location} from '@angular/common';
import {MessageService} from '../../service/message.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  idProductFormControl: FormControl;
  productNameFormControl: FormControl;
  productPriceFormControl: FormControl;
  matcher: AppErrorStateMatcher;

  product: Product;
  brands: Brand[];
  sections: Section[];

  constructor(private productService: ProductService,
              private brandService: BrandService,
              private sectionService: SectionService,
              private router: Router,
              private messageService: MessageService) { }

  ngOnInit() {
    this.initProduct();
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

  create() {
    this.productService.update(this.product).subscribe(data => {
      this.product = data;
      this.messageService.success('Produkt został dodany pomyślnie', 5000);
      this.router.navigate(['/products']);
    });
  }

  private initProduct() {
    this.product = new Product();
    this.product.brand = new Brand();
    this.product.section = new Section();
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
