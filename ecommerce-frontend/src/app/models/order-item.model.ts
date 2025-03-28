import { OrderModel } from "./order.model";
import { ProductModel } from "./product.model";

export interface OrderItemModel {
    id: number;
    order: OrderModel;
    product: ProductModel;
    quantity: number;
    price: number;
}
