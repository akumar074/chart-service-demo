import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { of, Observable } from 'rxjs'; 
import { switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ChartService {

  baseUrl = environment.baseUrl;

  token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c';

  constructor(private httpClient: HttpClient) { }

  getChartData(endpoint: string, inputData: any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Accept': 'application/json',
        'authToken': this.token
    }
    )};
    return this.httpClient.post(this.baseUrl + endpoint, inputData, httpOptions).pipe(
      switchMap(data =>  { return of(data) })
    );
  }
}
