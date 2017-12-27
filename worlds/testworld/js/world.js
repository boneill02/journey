var testRoom1 = new Room("TEST1", "just a test", null, null, true){};
var testRoom2 = new Room("TEST2", "just a test also", null, null, true){};
var weapon = new Weapon("WEAPON", "DESC", ["weapon"], false, 20, 1, 10){};
var player = new Player("Ben", "A wimpy dude", ["ben"], null, 500) {};

var exit = new Command("Exit", "Leave the game", [ "exit", "quit", "leave" ]) {
    exec: function(world, args) {
        world.setRunning(false);
        return true;
    }
};

var move = new Command("Move", "Move", [ "move", "go" ]) {
    exec: function(w, args) {
        if(args.length() === 1) {
            if(args[0] === "n" || args[0] === "north") {
                if(w.getMap().canGo(w.getX(), w.getY() + 1)) {
                    w.setRoom(w.getRoom(w.getX(), w.getY() + 1));
                    return;
                }
            } else if(args[0] === "s" || args[0] === "south") {
                if(w.getMap().canGo(w.getX(), w.getY() - 1)) {
                    w.setRoom(w.getRoom(w.getX(), w.getY() - 1));
                    return;
                }
            } else if(args[0] === "e" || args[0] === "east") {
                if(w.getMap().canGo(w.getX() + 1, w.getY())) {
                    w.setRoom(w.getRoom(w.getX() + 1, w.getY()));
                    return;
                }
            } else if(args[0] === "w" || args[0] === "west") {
                if(w.getMap().canGo(w.getX() - 1, w.getY())) {
                    w.setRoom(w.getRoom(w.getX() - 1, w.getY()));
                    return;
                }
            }
        }
        print("You can't go that way.");
    }
};

var commands = [exit, move];

var map = new WorldMap(){};
var maps = [map];
map.addRoom(testRoom1, 0, 0);
map.addRoom(testRoom2, 0, 1);
var world = new World("title", "description", "author", "copyright", "> ", maps,
                 testRoom1, commands, [], [], player){};