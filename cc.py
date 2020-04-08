print("Ceaser Cipher")
plaintext = input("Enter the plain text to be encrypted \n")
key = int(input("Enter the key(The key should be an integer)\n"))
cipher = ""

plain = plaintext.upper()
# print(plain)
for i in range(len(plain)): 
    temp = ord(plain[i])
    temp += key
    if temp > 90:
        temp -= 26
    cipher += chr(temp)

print(cipher+"\n")

dplain= input("Enter the Text to be decrypted \n")
dkey = int(input("Enter the key used in encryption \n"))
decrypt = ""

for i in range(len(dplain)):
    temp = ord(dplain[i])
    temp -= key
    if temp < 65:
        temp += 26
    if (chr(temp) == ":") :
        decrypt += " "
    else:
        decrypt += chr(temp)

print(decrypt, "\n")