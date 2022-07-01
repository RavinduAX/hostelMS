package lk.ijse.hms.bo;

import lk.ijse.hms.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        return (boFactory==null) ? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER, STUDENT, ROOM, REGISTRATION , RESERVED , LOGIN , CHECKOUT
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            case RESERVED:
                return new ReservedBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case CHECKOUT:
                return new CheckOutBOImpl();
            default:
                return null;
        }
    }

}
