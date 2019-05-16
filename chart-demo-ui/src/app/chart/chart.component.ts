import { Component, OnInit } from '@angular/core';
import { ChartService } from './services/chart.service';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {

  data: any;
  endpoint = 'getData';
  id = '';
  startDate: Date;
  endDate: Date;

  constructor(private chartService: ChartService) {
    this.data = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
          {
              label: 'My First dataset',
              backgroundColor: '#42A5F5',
              borderColor: '#1E88E5',
              data: [65, 59, 80, 81, 56, 55, 40]
          },
          {
              label: 'My Second dataset',
              backgroundColor: '#9CCC65',
              borderColor: '#7CB342',
              data: [28, 48, 40, 19, 86, 27, 90]
          }
      ]
  }
   }

  ngOnInit() {
  }

  getChartData() {
    const inputData = {
      '_id': 'dashboard1516252439345',
      "dateRange": {
        "startDate": new Date(this.startDate).getTime() / 1000,
        "endDate": new Date(this.endDate).getTime() / 1000,
      }
    }
    console.log(inputData);
    this.chartService.getChartData( this.endpoint , inputData).subscribe(data => this.data = data);
  }

}
