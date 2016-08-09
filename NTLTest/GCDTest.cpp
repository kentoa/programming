#include<iostream>
#include<vector>
#include<NTL/ZZXFactoring.h>

using namespace std;
using namespace NTL;

int main(){
  ZZX polyA, polyB;

  long a[] = {4, -5, 1}; // (x-1)(x-4)
  long b[] = {2, -3, 1}; // (x-1)(x-2)

  for(int i = 0; i < 3; i++){
    SetCoeff(polyA, i, a[i]);
    SetCoeff(polyB, i, b[i]);
  }

  ZZX gcd = GCD(polyA, polyB);

  cout << gcd << endl;
}
