package apr21;

import java.util.*;
import java.util.ArrayList;
public class TheCryptMapGeneration{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      int InitialyChar = 11;
      int InitialxChar = 11;
      int yChar = 0;
      int xChar = 0;
      int rooms = 0;
      int yCharRoom = 11;
      int xCharRoom = 11;
      int FloorNum = 1;
      int BossRoomOrientation = 0;
      double BattlePercent = 25;
      double ChestPercent = .25;
      double BoxPercent = 1;
      String BossRoomEntrance = "no";
      String BossRoom = "no";
      String orientation  = "";
      char[][] MapActual = new char[13][23];
      char[][] MapActualClear = new char[13][23];
      for(int y = 0; y < 1; ){
         for(int i = 0; i < 1;){
            int RoomGen = (int)(Math.random() * (100 + 1));
            for(int j = 0; j < MapActual.length; j++){
               for(int k = 0; k < MapActual[0].length; k++){
                  MapActual[j][k] = InitialMapGen(rooms, RoomGen, FloorNum, BossRoomOrientation, ChestPercent, BoxPercent, BossRoom, BossRoomEntrance)[j][k];
                  MapActualClear[j][k] = MapActual[j][k];
               }
            }
            for(int j = 0; j < MapActual.length; j++){
               for(int k = 0; k < MapActual[0].length; k++){
                  if(MapActual[j][k] == 'T'){
                     BossRoomEntrance = "yes";
                     k = MapActual[0].length;
                  }else{
                     BossRoomEntrance = "no";
                  }
               }
            }
            if(rooms > 0){
               if(BossRoom.equals("no")){
                  if(yChar == 12){
                     InitialyChar = 1;
                     InitialxChar = xChar;
                  }
                  if(yChar == 0){
                     InitialyChar = 11;
                     InitialxChar = xChar;
                  }
                  if(xChar == 22){
                     InitialxChar = 1;
                     InitialyChar = yChar;
                  }
                  if(xChar == 0){
                     InitialxChar = 21;
                     InitialyChar = yChar;
                  }
                  yCharRoom = InitialyChar;
                  xCharRoom = InitialxChar;
                  if(InitialyChar == 1 && 
                     orientation.equals("s")){
                     for(int u = 0; u < MapActual[0].length; u++){
                        if(MapActual[0][u] == 186){
                           if(u > 0){
                              xCharRoom = u;
                              u = MapActual[0].length;
                              if(BossRoomEntrance.equals("no")){
                                 MapActual[0][xCharRoom] = 'X';
                                 MapActualClear[0][xCharRoom] = 'X';
                              }
                              i++;
                           }
                        }
                     }
                  }
                  if(InitialyChar == 11 && 
                     orientation.equals("w")){
                     for(int u = 0; u < MapActual[0].length; u++){
                        if(MapActual[12][u] == 186){
                           if(u > 0){
                              xCharRoom = u;
                              u = MapActual[0].length;
                              if(BossRoomEntrance.equals("no")){
                                 MapActual[12][xCharRoom] = 'X';
                                 MapActualClear[12][xCharRoom] = 'X';
                              }
                              i++;
                           }
                        }
                     }
                  }
                  if(InitialxChar == 1 &&
                     orientation.equals("d")){
                     for(int u = 0; u < MapActual.length; u++){
                        if(MapActual[u][0] == 186){
                           if(u > 0){
                              yCharRoom = u;
                              u = MapActual[0].length;
                              if(BossRoomEntrance.equals("no")){
                                 MapActual[yCharRoom][0] = 'X';
                                 MapActualClear[yCharRoom][0] = 'X';
                              }
                              i++;
                           }
                        }
                     }
                  }
                  if(InitialxChar == 21 &&
                     orientation.equals("a")){
                     for(int u = 0; u < MapActual.length; u++){
                        if(MapActual[u][22] == 186){
                           if(u > 0){
                              yCharRoom = u;
                              u = MapActual[0].length;
                              if(BossRoomEntrance.equals("no")){
                                 MapActual[yCharRoom][22] = 'X';
                                 MapActualClear[yCharRoom][22] = 'X';
                              }
                              i++;
                           }
                        }
                     }
                  }
               }
            }
            InitialyChar = yCharRoom;
            InitialxChar = xCharRoom;
            xChar = InitialxChar;
            yChar = InitialyChar;
            if(rooms == 0){
               BossRoomOrientation = (int)(Math.random() * (3 + 1));
               if(BattlePercent + (20 / FloorNum) < 100){
                  BattlePercent += 20 / FloorNum;
               }
               if(ChestPercent + (.1 / FloorNum) > 0){
                  ChestPercent += .1 / FloorNum;
               }
               if(BoxPercent + (.1 / FloorNum) > 0){
                  BoxPercent += .1 / FloorNum;
               }
               i++;
            }
            if(BossRoom.equals("yes")){
               i++;
            }
         }
         BossRoomEntrance = "no";
         rooms++;
         for(int i = 0; i < 1;){
            String DoorOpen = "yes";
            MapActual[yChar][xChar] = 'R';
            for(int j = 0; j < 13; j++){
               for(int k = 0; k < 23; k++){
                  System.out.print(MapActual[j][k]);
               }
               System.out.println();
            }
            System.out.println();
            String direction = kb.next();
            int BattleRoll = (int)((Math.random() * 100) + 1);
            if(direction.equalsIgnoreCase("w") &&
            MapActual[yChar - 1][xChar] != 219 &&
            MapActual[yChar - 1][xChar] != 'X' &&
               yChar > 0){
               orientation = "w";
               if(MapActual[yChar - 1][xChar] == 186){
                  yChar--;
                  i++;
               }
               else if(MapActual[yChar - 1][xChar] == ']' ||
                        MapActual[yChar - 1][xChar] == 'T' ||
                        MapActual[yChar - 1][xChar] == '['){
                  BossRoom = "yes";
                  yCharRoom = 11;
                  xCharRoom = 11;
                  i++;
               }
               else{
                  if(rooms > 1 &&
                     BossRoom.equals("no")){
                     if(BattleRoll <= BattlePercent){
                        battle();
                     }
                  }
                  if(MapActual[yChar - 1][xChar] == 'D'){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the chest?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar - 1][xChar] = ' ';
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  else if(MapActual[yChar - 1][xChar] == 'N'){
                     System.out.println("Open");
                     MapActualClear[yChar - 1][xChar] = ' ';
                  }
                  else if(MapActual[yChar - 1][xChar] == '&'){
                     battle();
                     MapActualClear[yChar - 1][xChar] = 'H';
                     yChar++;
                  }
                  else if(MapActualClear[yChar - 1][xChar] == 'H'){
                     BossRoom = "no";
                     FloorNum++;
                     rooms = 0;
                     i++;
                  }
                  else if(MapActual[yChar - 1][xChar] == 254){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the door?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar - 1][xChar] = ' ';
                           MapActualClear[yChar - 2][xChar] = 221;
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           DoorOpen = "no";
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  if(DoorOpen == "yes"){
                     yChar--;
                  }
               }
            }
            else if(direction.equalsIgnoreCase("s") &&
               MapActual[yChar + 1][xChar] != 219 &&
               MapActual[yChar + 1][xChar] != 'X' &&
               yChar < 12){
               orientation = "s";
               if(MapActual[yChar + 1][xChar] == 186){
                  yChar++;
                  i++;
               }
               else if(MapActual[yChar + 1][xChar] == 239){
                  System.out.println("You exit the crypt");
                  y++;
                  i++;
               }
               else if(MapActual[yChar + 1][xChar] == ']' ||
                        MapActual[yChar + 1][xChar] == 'T' ||
                        MapActual[yChar + 1][xChar] == '['){
                  BossRoom = "yes";
                  yCharRoom = 11;
                  xCharRoom = 11;
                  i++;
               }
               else{
                  if(rooms > 1 &&
                     BossRoom.equals("no")){
                     if(BattleRoll <= BattlePercent){
                        battle();
                     }
                  }
                  if(MapActual[yChar + 1][xChar] == 'D'){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the chest?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar + 1][xChar] = ' ';
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  else if(MapActual[yChar + 1][xChar] == 'N'){
                     System.out.println("Open");
                     MapActualClear[yChar + 1][xChar] = ' ';
                  }
                  else if(MapActual[yChar + 1][xChar] == '&'){
                     battle();
                     MapActualClear[yChar + 1][xChar] = 'H';
                     yChar--;
                  }
                  else if(MapActualClear[yChar + 1][xChar] == 'H'){
                     BossRoom = "no";
                     FloorNum++;
                     rooms = 0;
                     i++;
                  }
                  else if(MapActual[yChar + 1][xChar] == 254){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the door?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar + 1][xChar] = ' ';
                           MapActualClear[yChar + 2][xChar] = 221;
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           DoorOpen = "no";
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  if(DoorOpen == "yes"){
                     yChar++;
                  }
               }
            }
            else if(direction.equalsIgnoreCase("a") &&
               MapActual[yChar][xChar - 1] != 219 &&
               MapActual[yChar][xChar - 1] != 'X' &&
               xChar > 0){
               orientation = "a";
               if(MapActual[yChar][xChar - 1] == 186){
                  xChar--;
                  i++;
               }
               else if(MapActual[yChar][xChar - 1] == ']' ||
                        MapActual[yChar][xChar - 1] == 'T' ||
                        MapActual[yChar][xChar - 1] == '['){
                  BossRoom = "yes";
                  yCharRoom = 11;
                  xCharRoom = 11;
                  i++;
               }
               else{
                  if(rooms > 1 &&
                     BossRoom.equals("no")){
                     if(BattleRoll <= BattlePercent){
                        battle();
                     }
                  }
                  if(MapActual[yChar][xChar - 1] == 'D'){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the chest?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar][xChar - 1] = ' ';
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  else if(MapActual[yChar][xChar - 1] == 'N'){
                     System.out.println("Open");
                     MapActualClear[yChar][xChar - 1] = ' ';
                  }
                  else if(MapActual[yChar][xChar - 1] == '&'){
                     battle();
                     MapActualClear[yChar][xChar - 1] = 'H';
                     xChar++;
                  }
                  else if(MapActualClear[yChar][xChar - 1] == 'H'){
                     BossRoom = "no";
                     FloorNum++;
                     rooms = 0;
                     i++;
                  }
                  else if(MapActual[yChar][xChar - 1] == 254){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the door?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar][xChar - 1] = ' ';
                           MapActualClear[yChar][xChar - 2] = 223;
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           DoorOpen = "no";
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  if(DoorOpen == "yes"){
                     xChar--;
                  }
               }
            }
            else if(direction.equalsIgnoreCase("d") &&
               MapActual[yChar][xChar + 1] != 219 &&
               MapActual[yChar][xChar + 1] != 'X' &&
               xChar < 22){
               orientation = "d";
               if(MapActual[yChar][xChar + 1] == 186){
                  xChar++;
                  i++;
               }
               else if(MapActual[yChar][xChar + 1] == ']' ||
                        MapActual[yChar][xChar + 1] == 'T' ||
                        MapActual[yChar][xChar + 1] == '['){
                  BossRoom = "yes";
                  yCharRoom = 11;
                  xCharRoom = 11;
                  i++;
               }
               else{
                  if(rooms > 1 &&
                     BossRoom.equals("no")){
                     if(BattleRoll <= BattlePercent){
                        battle();
                     }
                  }
                  if(MapActual[yChar][xChar + 1] == 'D'){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the chest?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar][xChar + 1] = ' ';
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  else if(MapActual[yChar][xChar + 1] == 'N'){
                     System.out.println("Open");
                     MapActualClear[yChar][xChar + 1] = ' ';
                  }
                  else if(MapActual[yChar][xChar + 1] == '&'){
                     battle();
                     MapActualClear[yChar][xChar + 1] = 'H';
                     xChar--;
                  }
                  else if(MapActualClear[yChar][xChar + 1] == 'H'){
                     BossRoom = "no";
                     FloorNum++;
                     rooms = 0;
                     i++;
                  }
                  else if(MapActual[yChar][xChar + 1] == 254){
                     for(int h = 0; h < 1;){
                        System.out.println("Do you want to use a key to open the door?");
                        String OpenChest = kb.next();
                        if(OpenChest.equalsIgnoreCase("yes")){
                           System.out.println("Open");
                           MapActualClear[yChar][xChar + 1] = ' ';
                           MapActualClear[yChar][xChar + 2] = 223;
                           h++;
                        }
                        else if(OpenChest.equalsIgnoreCase("no")){
                           System.out.println("Leave");
                           DoorOpen = "no";
                           h++;
                        }
                        else{
                           System.out.println("Please choose 'yes' or 'no.'");
                        }
                     }
                  }
                  if(DoorOpen == "yes"){
                     xChar++;
                  }
               }
            }
            for(int j = 0; j < 13; j++){
               for(int k = 0; k < 23; k++){
                  MapActual[j][k] = MapActualClear[j][k];
               }
            }
            if(rooms > 1){
               MapActualClear[InitialyChar][InitialxChar] = ' ';
            }
         }
         
      }
   }
   public static char[][] InitialMapGen(int rooms, int RoomGen, int FloorNum, int BossRoomOrientation, double ChestPercent, double BoxPercent, String BossRoom, String BossRoomEntrance){
      char[][] map = new char[13][23];
      for(int u = 0; u < 13; u++){
         for(int t = 0; t < 23; t++){
            map[u][t] = mapMake(rooms, RoomGen, FloorNum, BossRoomOrientation, BossRoom, BossRoomEntrance)[u][t];
         }
      }
      rooms++;
      for(int i = 1; i < 12; i++){
         for(int j = 1; j < 22; j++){
            double ItemGen = Math.random() * (100 + 1);
            if((map[i + 1][j] == 219 ||
                map[i - 1][j] == 219 ||
                map[i][j + 1] == 219 ||
                map[i][j - 1] == 219)&&
                map[i][j] == ' ' &&
                rooms > 1 &&
                ItemGen <= ChestPercent &&
                BossRoom.equals("no") &&
                map[i][j + 1] != 254 &&
                map[i][j - 1] != 254 &&
                map[i + 1][j] != 254 &&
                map[i - 1][j] != 254 ){
               map[i][j] = 'D';   
            }
            else if(map[i][j] == ' ' &&
                     rooms > 1 &&
                     ItemGen > 0.25 &&
                     ItemGen <= BoxPercent &&
                     BossRoom.equals("no") &&
                     map[i][j + 1] != 254 &&
                     map[i][j - 1] != 254 &&
                     map[i + 1][j] != 254 &&
                     map[i - 1][j] != 254){
               map[i][j] = 'N';
            }
         }
      }
      return map;
   }
   public static void battle(){
      System.out.println("Battle");
   }
   public static char[][] mapMake(int rooms, int RoomGen, int FloorNum, int BossRoomOrientation, String BossRoom, String BossRoomEntrance){
      if(rooms == 0){
         char[][] mapMake = {{ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), 186, ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ' ', ' ', ' ', ' ', ' ', ' ', ' ', ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)},
                             {ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), 239, ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219), ExtendedAscii.getAscii(219)}};
         return mapMake;
      }
      else if(BossRoom.equals("yes")){
         char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '&', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                             {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
         return mapMake;
      }
      else{
         if(RoomGen <= 33){
            char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 186},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 254, 219, 219, 219, 219, 219, 219, 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {186, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
            return mapMake;
         }
         else if(RoomGen > 80 &&
                 RoomGen < 100 &&
                 rooms > 5){
            if(BossRoomOrientation == 0){
               char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, '[', 'T', ']', 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
               return mapMake;
            }
            else if(BossRoomOrientation == 1){
               char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, '[', 'T', ']', 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
               return mapMake;
            }
            else if(BossRoomOrientation == 2){
               char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                   {']', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                   {'T', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 186},
                                   {']', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                   {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
               return mapMake;
            }
            else{
               char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '['},
                                   {186, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'T'},
                                   {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '['},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                   {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
               return mapMake;
            }
         }
         else if(RoomGen > 33 &&
                  RoomGen <= 66){
            char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 186},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {186, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 254, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
            return mapMake;
         }
         else{
            char[][] mapMake = {{219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {186, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, 219, 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 186},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 219},
                                {219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 186, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219, 219}};
            return mapMake;
         }
      }     
   }
}
