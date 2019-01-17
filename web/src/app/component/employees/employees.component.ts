import {Component, OnInit, ViewChild} from '@angular/core';
import {EmployeeService} from '../../service/employee.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Employee} from '../../model/employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[];
  dataSource: MatTableDataSource<Employee>;

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit() {
    this.displayedColumns = this.defineDispColumns();
    this.assignDataSource();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  private defineDispColumns(): string[] {
    return ['id', 'name', 'surname', 'email', 'phone', 'position'];
  }

  private assignDataSource() {
    this.employeeService.getAll().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  editEmployee(employee: Employee) {
    this.router.navigate(['/edit-employee/' + employee.idEmployee]);
  }

}
