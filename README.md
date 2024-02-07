# ChestDecoder Plugin Documentation

## Description
ChestDecoder is a Minecraft plugin designed to protect your chests from other users by assigning a code to each chest.

## Commands
### /lock {code}
Locks the chest the player is looking at with the specified code.

```java
/lock 1234
```

- `{code}`: A minimum 4-character code to lock the chest.
- Permission: `chestdecoder.lock`

### /decode {code}
Allows unlocking a locked chest with the specified code.

```java
/decode 1234
```

- `{code}`: A 4-character code to unlock the chest.
- Once unlocked, the code does not need to be entered again.
- Permission: `chestdecoder.decode`
