import { CartModel } from "./cart.model";
import { ProductModel } from "./product.model";

export interface CartItemModel {
    id: number;
    cartId: CartModel;
    productId: ProductModel;
    quantity: number;
}
