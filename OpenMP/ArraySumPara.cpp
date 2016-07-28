#include<omp.h>
#include<iostream>
#include<time.h>

#define N 10

using namespace std;

int main(){
  int a[N];
  int i, sum = 0;

  for(i = 0; i < N; i++){
    a[i] = i;
    
  }
  
  cout << "sum: " << sum << endl;

  clock_t st = clock();

  for(i = 0; i < N; i++){
    sum += a[i];
    cout << "i, sum: " << i << ", " << sum << endl;
  }  
  
  clock_t en = clock();
  
  cout << "sum: " << sum << endl;
  cout << "avg time: " << (double)(en -st)/CLOCKS_PER_SEC << " sec" << endl;


  st = clock();
  
#pragma omp parallel for reduction(+:sum)
  for(i = 0; i < N; i++){
    sum += a[i];
#pragma omp critical
    cout << "i, sum: " << i << ", " << sum << endl;
  }  

  en = clock();
  
  cout << "sum: " << sum << endl;
  cout << "avg time(para): " << (double)(en -st)/CLOCKS_PER_SEC << " sec" << endl;
  
  return 0;
}
