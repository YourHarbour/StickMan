Normal gradle build and run

Touch the Flag to transaction to the next level

The time used, time recommend , score , total score and lives at right up corner of screen

Use the "S" key to save the state, "L" key to reload

For the game equality, kill the same slime twice will not add the score.
For example, when the level start, press save, then kill one slime, then reload,
you will not get more marks from this slime, but you score which you kill this slime before will be recorded

Just like 'I Wanna', the reload is used for practice quicker pass the level and earn that part of score.

Design Pattern:
  Facade Pattern:
    LevelFecade, it include the control of all level transactions, it provide the static function which control
    and use all the subsystems of to the next level need.
    LoadFunction, control all the subsystems used for reload, include reset the level, entity position, etc.
  Memento Pattern:
    The Save and Load function depends on the memento pattern, it includes a careTaker and a memento, which careTaker saves the Memento and Memento saves the states of recorded level
  Observer Pattern:
    The TextObserver is an interface which control all three observers (HpText,TimeText,ScoreText)
