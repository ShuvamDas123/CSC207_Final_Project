To run our program, run the main method at the bottom of the InterfaceController class. When it first runs,
the console will prompt you to enter in a username and password. Here are some of the login credentials for users saved
in the program:

Organizer "chris" "pineapples123"
Organizer "stevens5" "Grapes64'
Organizer "mbrian2" "hello2000"
Speaker "Markus" "longbottom"
Attendee "1roka" "TacoTuesday"
Attendee "hnguyen" "0BigMac0"
Attendee "msali70" "92!@f7"

Once signed in, the menu will prompt you to input a series of indexes which will navigate you through different parts of
the program. In any of these menus, you can type "exit" to return to the main menu. Typing "exit" on the main menu will
exit the program.

Not much data is stored in the .ser files currently, so logging into an organizer account and creating events/rooms
is recommended.

To switch users, you will have to use the "exit" command and rerun main to log in as another user.

As for how data is saved in our program, data will ONLY save if the user exits the program using the "exit" command on
the main menu. Otherwise, any objects created will not be serialized when the program is closed.