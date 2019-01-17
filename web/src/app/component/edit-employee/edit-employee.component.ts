import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee';
import {AppErrorStateMatcher} from '../../util/app-error-state-matcher';
import {FormControl, Validators} from '@angular/forms';
import {EmployeeService} from '../../service/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MessageService} from '../../service/message.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  idEmployeeFormControl: FormControl;
  employeeNameFormControl: FormControl;
  employeeSurnameFormControl: FormControl;
  emailFormControl: FormControl;
  telephoneNumberFormControl: FormControl;
  positionFormControl: FormControl;

  matcher: AppErrorStateMatcher;
  employee: Employee;

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private messageService: MessageService,
              private location: Location,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.createFormControls();
    this.setEmployee();
    this.matcher = new AppErrorStateMatcher();
  }

  isFormValid() {
    return this.idEmployeeFormControl.valid &&
      this.employeeNameFormControl.valid &&
      this.employeeSurnameFormControl.valid &&
      this.emailFormControl.valid &&
      this.telephoneNumberFormControl.valid &&
      this.positionFormControl.valid;
  }

  update() {
    this.employeeService.update(this.employee).subscribe(data => {
      this.employee = data;
      this.messageService.success('Edycja została pomyślnie zakończona', 5000);
      this.router.navigate(['/employees']);
    });
  }

  back() {
    this.location.back();
  }

  private setEmployee() {
    const id = this.route.snapshot.paramMap.get('id');
    this.employeeService.getById(id).subscribe(data => {
      this.employee = data;
    }, error => {
      this.router.navigate(['/error']);
    });
  }

  private createFormControls() {
    this.idEmployeeFormControl = new FormControl('', [
      Validators.required,
      Validators.pattern('[0-9]+')
    ]);
    this.employeeNameFormControl = new FormControl('', [
      Validators.required
    ]);
    this.employeeSurnameFormControl = new FormControl('', [
      Validators.required
    ]);
    this.emailFormControl = new FormControl('', [
      Validators.required,
      Validators.email
    ]);
    this.telephoneNumberFormControl = new FormControl('', [
      Validators.pattern('[0-9]+')
    ]);
    this.positionFormControl = new FormControl('', [
      Validators.required
    ]);
  }

}
