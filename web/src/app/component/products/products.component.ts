import {Component, OnInit, ViewChild} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Product} from '../../model/product';
import {Router} from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[];
  dataSource: MatTableDataSource<Product>;

  constructor(private productService: ProductService,
              private router: Router) { }

  ngOnInit() {
    this.displayedColumns = this.defineDispColumns();
    this.assignDataSource();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  private defineDispColumns(): string[] {
    return ['brandName', 'productName', 'sectionName', 'productPrice'];
  }

  private assignDataSource() {
    this.productService.getAll().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.specifyFilterPredicate();
    });
  }

  private specifyFilterPredicate() {
    this.dataSource.filterPredicate = (data, filter) => {
      const dataStr = data.productName
            + data.productPrice
            + data.brand.brandName.toLowerCase()
            + data.section.sectionName.toLowerCase();
      return dataStr.indexOf(filter) !== -1;
    };
  }

  editProduct(product: Product) {
    this.router.navigate(['/edit-product/' + product.idProduct]);
  }

}
