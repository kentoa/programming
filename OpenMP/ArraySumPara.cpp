#include<omp.h>
#include<iostream>

#define N 10

using namespace std;

int main(){
  int a[N];
  int i, sum = 0;
  
#pragma omp parallel for reduction(+:sum)
  for(i = 0; i < N; i++){
    sum += a[i];
#pragma omp critical
    cout << "i, sum: " << i << ", " << sum << endl;
  }  
  
  cout << "sum: " << sum << endl;
  
  return 0;
}
