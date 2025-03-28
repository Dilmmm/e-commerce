import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CategoryModel } from '../../models/category.model';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/category';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getCategories(): Observable<CategoryModel[]> {
    return this.http.get<CategoryModel[]>(baseUrl + "/all");
  }
}
