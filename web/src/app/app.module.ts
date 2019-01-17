import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppMaterialModule} from './material/app-material.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {AppRoutingModule} from './app-routing.module';
import {EmptyLayoutComponent} from './layouts/empty-layout/empty-layout.component';
import {LoginComponent} from './login/login.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {HeaderComponent} from './header/header.component';
import {TemplateLayoutComponent} from './layouts/template-layout/template-layout.component';
import {SideNavComponent} from './side-nav/side-nav.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {AuthGuard} from './guard/auth.guard';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RequestInterceptor} from './interceptor/request-interceptor';
import {NgHttpLoaderModule} from 'ng-http-loader';
import { EmployeesComponent } from './component/employees/employees.component';
import { AddEmployeeComponent } from './component/add-employee/add-employee.component';
import { StoresComponent } from './component/stores/stores.component';
import {MatPaginatorIntlCus} from './intl/mat-paginator-intl-cus';
import {MatPaginatorIntl} from '@angular/material';
import {AgmCoreModule} from '@agm/core';
import { ProductsComponent } from './component/products/products.component';
import { EditProductComponent } from './component/edit-product/edit-product.component';
import { ErrorComponent } from './component/error/error.component';
import { AddProductComponent } from './component/add-product/add-product.component';
import { EditEmployeeComponent } from './component/edit-employee/edit-employee.component';
import { ReportsComponent } from './component/reports/reports.component';

@NgModule({
  declarations: [
    AppComponent,
    EmptyLayoutComponent,
    TemplateLayoutComponent,
    HeaderComponent,
    SideNavComponent,
    DashboardComponent,
    LoginComponent,
    EmployeesComponent,
    AddEmployeeComponent,
    StoresComponent,
    ProductsComponent,
    EditProductComponent,
    ErrorComponent,
    AddProductComponent,
    EditEmployeeComponent,
    ReportsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AppMaterialModule,
    AngularFontAwesomeModule,
    FlexLayoutModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgHttpLoaderModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAblRsB-tJOj2Duobakak71GtzdXGlO52Q'
    })
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true,
    },
    { provide: MatPaginatorIntl, useClass: MatPaginatorIntlCus }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
