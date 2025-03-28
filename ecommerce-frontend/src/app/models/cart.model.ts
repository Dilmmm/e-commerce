import { UserModel } from "./user.model";

export interface CartModel {
    id: number;
    user: UserModel;
    creationDate: string;
}
