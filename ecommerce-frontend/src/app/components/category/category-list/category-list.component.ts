import { Component, OnInit } from '@angular/core';
import { CategoryModel } from '../../../models/category.model';
import { CategoryService } from '../../../services/category/category.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit {
  categories: CategoryModel[] = [];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.allCategories();
  }
  allCategories() {
    this.categoryService.getCategories().subscribe((data: CategoryModel[]) => {
      this.categories = data;
    });
  }

}
