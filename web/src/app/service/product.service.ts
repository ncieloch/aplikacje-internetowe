import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from './authentication.service';
import {Observable} from 'rxjs';
import {AppComponent} from '../app.component';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) { }

  getAll(): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/products', this.authenticationService.jwt());
  }

  create(product: Product): Observable<any> {
    return this.http.post(AppComponent.API_URL + '/products', product, this.authenticationService.jwt());
  }

  getById(id): Observable<any> {
    return this.http.get(AppComponent.API_URL + '/products/' + id, this.authenticationService.jwt());
  }

  update(product: Product): Observable<any> {
    return this.http.put(AppComponent.API_URL + '/products', product, this.authenticationService.jwt());
  }

}
