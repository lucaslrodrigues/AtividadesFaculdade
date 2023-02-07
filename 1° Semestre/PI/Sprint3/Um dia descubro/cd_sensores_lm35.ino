 int lm35_pin = A1, leitura_lm35 = 0;
 float temperatura; 

  void setup()  
{ 
  Serial.begin(9600);
}  
 void loop()
  {  

 leitura_lm35 = analogRead(lm35_pin);
   temperatura = leitura_lm35 * (5.0/1023) * 100;
 Serial.print(temperatura);   Serial.print(";");
  
if (isnan(temperatura))
{
Serial.println("Erro ao ler o LM35");
}
else
{
Serial.print(temperatura*0.60);
Serial.print(";");
Serial.print(temperatura*0.61);
Serial.print(";");
Serial.print(temperatura*0.69);
Serial.print(";");
Serial.print(temperatura*0.65);
Serial.print(";");
Serial.print(temperatura*0.66);
Serial.print(";");


Serial.print(temperatura*0.60);
Serial.print(";");
Serial.print(temperatura*0.61);
Serial.print(";");
Serial.print(temperatura*0.69);
Serial.print(";");
Serial.print(temperatura*0.65);
Serial.print(";");
Serial.print(temperatura*0.66);
Serial.print(";");


Serial.print(temperatura*0.60);
Serial.print(";");
Serial.print(temperatura*0.61);
Serial.print(";");
Serial.print(temperatura*0.69);
Serial.print(";");
Serial.print(temperatura*0.65);
Serial.print(";");
Serial.print(temperatura*0.66);
Serial.print(";");
Serial.println(temperatura*0.60);

delay(1000);
}}
