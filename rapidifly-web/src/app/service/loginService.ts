import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { tap } from "rxjs";
import * as CryptoJS from 'crypto-js';



@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
    url = 'http://localhost:8080/'
    constructor(private http: HttpClient) { }

    verifica(login : any){
      return this.http.post(this.url + 'login' , JSON.stringify(login),
      { headers: { 'Content-Type': 'application/json' } })
      .pipe(
        tap(res => {
          return res;
        })
      );
    }
  }