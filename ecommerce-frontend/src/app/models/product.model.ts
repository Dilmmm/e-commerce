import { CategoryModel } from "./category.model";

export interface ProductModel {
    id: number;
    name: string;
    description: string;
    price: number;
    stockQuantity: number;
    category: CategoryModel;
    creationDate: string;
}
