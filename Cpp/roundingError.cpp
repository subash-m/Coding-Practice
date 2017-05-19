#include<iostream>
#include<iomanip>

int main(){

	// 1/10  =  0.1 in decimal
	// 0.000110011001100.. in binary
	// because of which we will run into precision problems.
	double d(0.1);
	std::cout << d << std::endl;
	std::cout << std::setprecision(17);
	std::cout << d << std::endl;
	
	std::cout << "This is because the double had to truncate the \n \
approximation due to its limited memory, which resulted in a number \n \
that is not exactly 0.1. This is called rounding error, which grows on \n \
multiplication and division\n";
	return 0;
}
