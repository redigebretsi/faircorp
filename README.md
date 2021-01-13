# Faircorp
This is Application that can control room,window and heater in a building.

###          Futures that can Work
Http requests such as\
api/Windows (GET) send windows list\
/api/Windows (POST) add a window\
/api/Windows/{window_id} (GET) read a window\
/api/Windows/{window_id} (DELETE) delete a window

/api/heaters (GET) send heaters list\
/api/heaters (POST) add a heater\
/api/heaters/{heater_id} (GET) read a heater\
/api/heaters/{heater_id} (DELETE) delete a heater

/api/rooms (GET) send room list\
/api/rooms (POST) add a room\
/api/rooms/{room_id} (GET) read a room\
/api/rooms/{room_id} (DELETE) delete a room and all its windows and its heaters\
/api/rooms/{room_id}/switchWindow switch the room windows (OPEN to CLOSED or inverse)\
/api/rooms/{room_id}/switchHeaters switch the room heaters (ON to OFF or inverse)\
###          This app can be run on clever cloud 

