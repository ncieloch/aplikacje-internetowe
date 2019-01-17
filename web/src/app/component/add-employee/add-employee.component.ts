import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee';
import {EmployeeService} from '../../service/employee.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AppErrorStateMatcher} from '../../util/app-error-state-matcher';
import {Router} from '@angular/router';
import {MessageService} from '../../service/message.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

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
              private messageService: MessageService) { }

  ngOnInit() {
    this.createFormControls();
    this.employee = new Employee();
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

  create() {
    this.employeeService.create(this.employee).subscribe(data => {
      this.employee = data;
      this.messageService.success('Pracownik został dodany pomyślnie', 5000);
      this.router.navigate(['/dashboard']);
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
