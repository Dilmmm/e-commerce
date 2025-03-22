import { UserModel } from "./user.model";

export interface CartModel {
    id: number;
    userId: UserModel;
    creationDate: string;
}
