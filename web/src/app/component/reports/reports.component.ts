import {Component, OnInit} from '@angular/core';
import {ProductReportService} from '../../service/product-report.service';
import {ProductSalesReport} from '../../model/product-sales-report';
import * as Chart from 'chart.js';
import {StoreSalesReport} from '../../model/store-sales-report';
import {StoreReportService} from '../../service/store-report.service';
import {BillOfSaleReportService} from '../../service/bill-of-sale-report.service';
import {BillOfSaleReport} from '../../model/bill-of-sale-report';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  productSalesReports: ProductSalesReport[];
  productSalesReportsChart: Chart;
  productSalesReportValues: any;

  storeSalesReports: StoreSalesReport[];
  storeSalesReportsChart: Chart;
  storeSalesReportValues: any;

  billOfSaleReports: BillOfSaleReport[];
  billOfSaleReportsChart: Chart;
  billOfSaleReportValues: any;

  constructor(private productReportService: ProductReportService,
              private storeReportService: StoreReportService,
              private billOfSaleReportService: BillOfSaleReportService) {
  }

  ngOnInit() {
    this.assignProductSalesReport();
    this.assignStoreSalesReport();
    this.assignBillOfSaleReport();
  }

  private assignProductSalesReport() {
    this.productReportService.getReport().subscribe(data => {
      this.productSalesReports = data;
      this.getMostSoldProducts();
      this.prepareProductSalesChart();
    });
  }

  private getMostSoldProducts() {
    this.productSalesReportValues = {};
    this.productSalesReportValues.labels = [];
    this.productSalesReportValues.values = [];
    for (let i = 0; i < 5; i++) {
      this.productSalesReportValues.labels.push(this.productSalesReports[i].productName);
      this.productSalesReportValues.values.push(this.productSalesReports[i].soldCount);
    }
  }

  private prepareProductSalesChart() {
    this.productSalesReportsChart = new Chart('productSalesReportChart', {
      type: 'horizontalBar',
      data: {
        labels: this.productSalesReportValues.labels,
        datasets: [{
          data: this.productSalesReportValues.values,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          xAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        },
        legend: {
          display: false
        }
      }
    });
  }

  private assignStoreSalesReport() {
    this.storeReportService.getReport().subscribe(data => {
      this.storeSalesReports = data;
      this.getTopStores();
      this.prepareStoreSalesChart();
    });
  }

  private getTopStores() {
    this.storeSalesReportValues = {};
    this.storeSalesReportValues.labels = [];
    this.storeSalesReportValues.values = [];
    for (let i = 0; i < 5; i++) {
      this.storeSalesReportValues.labels.push(this.storeSalesReports[i].storeAddress);
      this.storeSalesReportValues.values.push(this.storeSalesReports[i].soldCount);
    }
  }

  private prepareStoreSalesChart() {
    this.storeSalesReportsChart = new Chart('storeSalesReportChart', {
      type: 'horizontalBar',
      data: {
        labels: this.storeSalesReportValues.labels,
        datasets: [{
          data: this.storeSalesReportValues.values,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          xAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        },
        legend: {
          display: false
        }
      }
    });
  }

  private assignBillOfSaleReport() {
    this.billOfSaleReportService.getReport().subscribe(data => {
      this.billOfSaleReports = data;
      this.prepareData();
      this.prepareBillOfSaleChart();
    });
  }

  private prepareData() {
    this.billOfSaleReportValues = {};
    this.billOfSaleReportValues.labels = [];
    this.billOfSaleReportValues.values = [];
    for (let i = 0; i < this.billOfSaleReports.length; i++) {
      this.billOfSaleReportValues.labels.push(this.billOfSaleReports[i].month);
      this.billOfSaleReportValues.values.push(this.billOfSaleReports[i].soldCount);
    }
  }

  private prepareBillOfSaleChart() {
    this.billOfSaleReportsChart = new Chart('billOfSaleReportChart', {
      type: 'line',
      data: {
        labels: this.billOfSaleReportValues.labels,
        datasets: [{
          data: this.billOfSaleReportValues.values,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          xAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        },
        legend: {
          display: false
        }
      }
    });
  }

}
