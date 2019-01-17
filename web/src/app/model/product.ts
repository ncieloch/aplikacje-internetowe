import {CurrencyPipe} from '@angular/common';
import {Brand} from './brand';
import {Section} from './section';

export class Product {
  idProduct: number;
  productName: string;
  productPrice: CurrencyPipe;
  brand: Brand;
  section: Section;
}
