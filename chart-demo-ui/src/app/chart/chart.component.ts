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
  id = 'dashboard1516252439345';
  startDate: Date;
  endDate: Date;
  advertiseIds = [];
  impressionsOffered = [];
  cm001s = [];

  constructor(private chartService: ChartService) { }

  ngOnInit() {
  }

  getChartData() {
    const inputData = {
      "id": "dashboard1516252439345",
      "dateRange": {
        "startDate": new Date(this.startDate).getTime() / 1000,
        "endDate": new Date(this.endDate).getTime() / 1000,
      }
    }
    this.chartService.getChartData(this.endpoint, inputData).subscribe((data: any[]) => {
      this.advertiseIds = this.impressionsOffered = this.cm001s = [];
      data.map(obj => {
        this.advertiseIds.push(obj['advertiserId']);
        this.impressionsOffered.push(Number(obj['impressions_offered']));
        this.cm001s.push(Number(obj['CM001']));
      });
      this.data = {
        labels: this.advertiseIds,
        datasets: [
          {
            label: 'impressions_offered',
            backgroundColor: '#42A5F5',
            borderColor: '#1E88E5',
            data: this.impressionsOffered
          },
          {
            label: 'CM001',
            backgroundColor: '#9CCC65',
            borderColor: '#7CB342',
            data: this.cm001s
          }
        ]
      }
    });
  }

}
