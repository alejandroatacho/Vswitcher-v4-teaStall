//Title:V4 Tea Stall Robber Support Banking & Powerdropping
//______________________________________________________________________________________________
int user_decision = 1;
//0 = Drop tea //more exp per hour
//1 = Bank tea //for 10 hp ironmans?
//______________________________________________________________________________________________

//Hinamizawa's Variables Down Below, don't touch :v 
int teaId = 1978;
WorldPoint currentLocation = client.getLocalPlayer().getWorldLocation();
WorldPoint safeLocation = new WorldPoint(3269, 3412 , 0);
int opCode = 4;
int stall_action_id = 635;
GameObject stall = v.getGameObject().findNearest(stall_action_id);
int stallSceneX = stall.getSceneMinLocation().getX();
int stallSceneY = stall.getSceneMinLocation().getY();
int bankId = 10583;
int opCode2 = 4;
GameObject bankBooth = v.getGameObject().findNearest(bankId);
int bankBoothSceneX = bankBooth.getSceneMinLocation().getX();
int bankBoothSceneY = bankBooth.getSceneMinLocation().getY();

if (user_decision == 0) {
    
    if (!currentLocation.equals(safeLocation) && !v.getWalking().isMoving()) {
        v.getWalking().walk(safeLocation);
    } 

    else if (!v.getInventory().inventoryFull() && !v.getWalking().isMoving() && v.getLocalPlayer().hasAnimation(-1) && currentLocation.equals(safeLocation)) {
        if (stall != null){
        v.invoke("Steal-from", "<col=ffff>Tea stall", stall_action_id, opCode, stallSceneX, stallSceneY, false);
        }
    }
    else if (v.getInventory().inventoryFull() && !v.getWalking().isMoving() && v.getLocalPlayer().hasAnimation(-1) && currentLocation.equals(safeLocation)) {
        v.getInventory().drop(teaId);
    }

} else if (user_decision == 1) {

    if (!currentLocation.equals(safeLocation) && !v.getWalking().isMoving() && !v.getInventory().inventoryFull()) {
        v.getWalking().walk(safeLocation);
    } 
    else if (currentLocation.equals(safeLocation) && !v.getWalking().isMoving() && v.getInventory().inventoryFull() && !v.getBank().isOpen()) {
        if (bankBooth != null) {
            v.invoke("Bank", "<col=ffff>Bank booth", bankId, opCode2, bankBoothSceneX, bankBoothSceneY, false);
           
        }
    }
    else if (!currentLocation.equals(safeLocation) && !v.getWalking().isMoving() && v.getInventory().inventoryFull() && v.getBank().isOpen()) {
         v.getBank().deposit(teaId, 28);
         v.invoke("Close", "", 1, 57, 11, 786434, false);
    }
        else if (!v.getInventory().inventoryFull() && !v.getWalking().isMoving() && v.getLocalPlayer().hasAnimation(-1) && currentLocation.equals(safeLocation)) {
         if (stall != null){
        v.invoke("Steal-from", "<col=ffff>Tea stall", stall_action_id, opCode, stallSceneX, stallSceneY, false);
        }
    }
}
