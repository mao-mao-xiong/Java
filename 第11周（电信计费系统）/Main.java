import tv.*;
import tvfactory.*;
import xml.ReadXMLUtilDX;
public class Main{
public static void main(String args[]){
Dx dx;
String brandName =ReadXMLUtilDX.getBrandName();
dx =DXFactory.produceDx(brandName);
dx.play();
}
}