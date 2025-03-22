import { RoleEnum } from "../enums/role.enum";

export interface UserModel {
    id: number;
    userName: string;
    email: string;
    password: string;
    creationDate: string;
    isActive: boolean;
    role: RoleEnum;
}
