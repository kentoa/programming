#include<iostream>
#include<NTL/ZZ.h>

using namespace std;
using namespace NTL;

int main(){
  ZZ a = to_ZZ("3"), b = to_ZZ("5");

  ZZ sum = a + b;
  cout << "ZZ sum: " << sum << endl;

  ZZ mul = a * b;
  cout << "ZZ multiplication: " << mul << endl;

  ZZ sub = a - b;
  cout << "ZZ subtraction: " << sub << endl;
}
