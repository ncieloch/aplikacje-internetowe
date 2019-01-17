import {NgModule} from '@angular/core';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {
  MatPaginatorModule,
  MatSelectModule,
  MatTableModule,
  MatTooltipModule
} from '@angular/material';

@NgModule({
  exports: [
    MatToolbarModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatSnackBarModule,
    MatListModule,
    MatTooltipModule,
    MatCardModule,
    MatTableModule,
    MatPaginatorModule,
    MatSelectModule
  ]
})
export class AppMaterialModule { }
