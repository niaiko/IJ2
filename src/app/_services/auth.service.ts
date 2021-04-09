import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:5425/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      id: credentials.id,
      password: credentials.password
    },  { observe: 'response' });
  }

  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      id : user.id,
      username: user.username,
      email: user.email,
      password: user.password,
      role : user.role
    }, { observe: 'response' });
  }
}
