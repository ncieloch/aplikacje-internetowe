import { Injectable } from '@angular/core';
import {MatSnackBar} from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  constructor(private snacBar: MatSnackBar) {
  }

  success(message: string, period: number) {
    this.snacBar.open(message, null, {
      duration: period,
      horizontalPosition: 'right',
      verticalPosition: 'bottom',
      panelClass: ['my-snack-bar--success']
    });
  }

  error(message: string, period: number) {
    this.snacBar.open(message, null, {
      duration: period,
      horizontalPosition: 'right',
      verticalPosition: 'bottom',
      panelClass: ['my-snack-bar--error']
    });
  }

  warning(message: string, period: number) {
    this.snacBar.open(message, null, {
      duration: period,
      horizontalPosition: 'right',
      verticalPosition: 'bottom',
      panelClass: ['my-snack-bar--warning']
    });
  }

  info(message: string, period: number) {
    this.snacBar.open(message, null, {
      duration: period,
      horizontalPosition: 'right',
      verticalPosition: 'bottom',
      panelClass: ['my-snack-bar--info']
    });
  }
}
