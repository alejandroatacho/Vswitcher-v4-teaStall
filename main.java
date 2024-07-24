int teaId = 1978;
WorldPoint currentLocation = client.getLocalPlayer().getWorldLocation();
WorldPoint safeLocation = new WorldPoint(3269, 3412 , 0);
int opCode = 4;
int stall_action_id = 635;
GameObject stall = v.getGameObject().findNearest(stall_action_id);
int stallSceneX = stall.getSceneMinLocation().getX();
int stallSceneY = stall.getSceneMinLocation().getY();

if (!currentLocation.equals(safeLocation) && !v.getWalking().isMoving()) {
        v.getWalking().walk(safeLocation);
    } 

else if (!v.getInventory().inventoryFull() && !v.getWalking().isMoving() && v.getLocalPlayer().hasAnimation(-1) && currentLocation.equals(safeLocation)) {
v.invoke("Steal-from", "<col=ffff>Tea stall", stall_action_id, opCode, stallSceneX, stallSceneY, false);
}
else if (v.getInventory().inventoryFull() && !v.getWalking().isMoving() && v.getLocalPlayer().hasAnimation(-1) && currentLocation.equals(safeLocation)) {
        v.getInventory().drop(teaId);

}