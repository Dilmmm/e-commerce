import { OrderModel } from "./order.model";
import { ProductModel } from "./product.model";

export interface OrderItemModel {
    id: number;
    orderId: OrderModel;
    productId: ProductModel;
    quantity: number;
    price: number;
}
