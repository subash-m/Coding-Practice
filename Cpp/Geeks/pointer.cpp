#include<iostream>

using namespace std;

int main(){
	int arr[] = {1, 2, 3};
	int *ptr = arr;
	cout << ptr[0] << ptr[1] << endl;
	cout << *ptr << *ptr+1 << *(ptr+1)<<endl;

/*	int array[2][3] = {{10, 20, 30}, {40, 50, 60}};
	int (*pointer)[2][3];
	pointer = &array;*/
	int **pointer = new int*[2];
	for(int i(0); i<2; i++){
		pointer[i] = new int[3];
	}
	for (int i(0); i<2; i++){
		for(int j(0); j<3; j++){
			pointer[i][j] = j+10+i*10;
			cout<<pointer[i][j]<<"  ";
		}
		cout<<endl;
	}

	cout << "**pointer = " << **pointer<<endl;
	cout << "*(*pointer+1) = " << *(*pointer+1)<<endl;
	cout << "*(*(pointer)+1) = " << *(*(pointer)+1)<<endl;
	cout << "*((*pointer)+1) = " << *((*pointer)+1)<<endl;
	cout << "(*(*pointer))+1 = " << *(*pointer)+1<<endl;
	cout << "**(pointer+1) = " << **(pointer+1)<<endl;
	cout << "*(*(pointer+1)+1) = " << *(*(pointer+1)+1)<<endl;
	return 0;
}
