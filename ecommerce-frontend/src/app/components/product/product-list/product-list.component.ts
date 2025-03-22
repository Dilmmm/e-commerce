import { Component, OnInit } from '@angular/core';
import { ProductModel } from '../../../models/product.model';
import { ProductService } from '../../../services/product.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {
  products: ProductModel[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.allProducts();
  }
  allProducts() {
    this.productService.getProducts().subscribe((data: ProductModel[]) => {
      this.products = data;
    });
  }

}
