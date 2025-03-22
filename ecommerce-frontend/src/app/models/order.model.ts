import { OrderStatusEnum } from "../enums/order-status.enum";
import { UserModel } from "./user.model";

export interface OrderModel {
    id: number;
    userId: UserModel;
    totalAmount: number;
    orderDate: string;
    status: OrderStatusEnum;
}
