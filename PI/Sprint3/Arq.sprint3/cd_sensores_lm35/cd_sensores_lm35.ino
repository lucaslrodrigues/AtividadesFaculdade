int switch_pin = 7;
void setup()
{
Serial.begin(9600);
pinMode(switch_pin, INPUT);
}
void loop()
{

if(digitalRead(switch_pin) == LOW){
Serial.print(";");
Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.println(";");
}
else {
Serial.print(";");
Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(0);
Serial.print(";");

Serial.print(1);
Serial.print(";");

Serial.print(0);
Serial.println(";");
}
delay(2000);

}
