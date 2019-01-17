import { NgModule } from '@angular/core';

import {RouterModule, Routes} from '@angular/router';
import {EmptyLayoutComponent} from './layouts/empty-layout/empty-layout.component';
import {TemplateLayoutComponent} from './layouts/template-layout/template-layout.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './guard/auth.guard';
import {EmployeesComponent} from './component/employees/employees.component';
import {AddEmployeeComponent} from './component/add-employee/add-employee.component';
import {StoresComponent} from './component/stores/stores.component';
import {ProductsComponent} from './component/products/products.component';
import {EditProductComponent} from './component/edit-product/edit-product.component';
import {ErrorComponent} from './component/error/error.component';
import {AddProductComponent} from './component/add-product/add-product.component';
import {EditEmployeeComponent} from './component/edit-employee/edit-employee.component';
import {ReportsComponent} from './component/reports/reports.component';

const routes: Routes = [
  {
    path: '',
    component: TemplateLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'employees',
        component: EmployeesComponent
      },
      {
        path: 'add-employee',
        component: AddEmployeeComponent
      },
      {
        path: 'stores',
        component: StoresComponent
      },
      {
        path: 'products',
        component: ProductsComponent
      },
      {
        path: 'edit-product/:id',
        component: EditProductComponent
      },
      {
        path: 'add-product',
        component: AddProductComponent
      },
      {
        path: 'edit-employee/:id',
        component: EditEmployeeComponent
      },
      {
        path: 'reports',
        component: ReportsComponent
      }
    ]
  },
  {
    path: '',
    component: EmptyLayoutComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'error',
        component: ErrorComponent
      }
    ]
  },
  {
    path: '**',
    redirectTo: 'dashboard'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
