print ("Hello Ranjan!")
##print('Interest Calculator:')
##amount = float(input('Principal amount ?'))
##roi = float(input('Rate of Interest ?'))
##years = int(input('Duration (no. of years) ?'))
##total = (amount * pow(1 + (roi/100), years))
##interest = total - amount
##print('\nInterest = %0.2f' %interest)
def demo_routine(num):
    print('I am a demo function')
    if num % 2 == 0:
        return True
    else:
        return False

num = 7980356821
if demo_routine(num) is True:
    print(num, 'is an even number')
else:
    print(num, 'is an odd number')
inum = 10+2j
print(type(inum))
inum2= complex(1.2,6)
print(inum2,"   ",type(inum2))
str = """This is a multi-line string.
This is for test purpose.
This is strange way of writing Strings."""
print("Multi-Line String:\n\n",str)
str2 = "Learn Python"
print("Original String: ",str2)
print("first_5_chars: ",str2[0:5])
print("substr_from_2_to_5: ", str2[1:5])
print("substr_from_6_to_end: ",str2[6:])
print("last_2_chars: ",str2[-2:])
print("first_2_chars: ",str2[:2])
print("two_chars_before_last: ",str2[-3:-1])
print("reverse: ",str2[::-1])

numbers = [1,1,2,3,4]
print("List: ",numbers)
alphabets = ('A','B','C')
print("Tuples: ",alphabets)
unique_set = {1,2,3,4,4}
print("Set: ",unique_set)
frozen_set = frozenset([1,2,3,67,1])
print("Frozen Set: ",frozen_set)
print(set(numbers))

sample_dict = {'Jan':31,'Feb':28,'Mar':31,'Apr':30,'May':31,'Jun':30,'Jul':31,
               'Aug':31,'Sep':30,'Oct':31,'Nov':30,'Dec':31}
print(sample_dict['Apr'])
print("keys: ",sample_dict.keys())
print("values: ",sample_dict.values())
print("items: ",sample_dict.items())
print("type of keys: ",type(sample_dict.keys()))
print("type of values: ",type(sample_dict.values()))
print("type of items: ",type(sample_dict.items()))

consecutive_list = [itr + 1 for itr in range(10)]
print(consecutive_list)
first_letters_months = [months[0] for months in sample_dict.keys()]
print(first_letters_months)
print ([x+y for x in 'get' for y in 'set'])
print ([x+y for x in 'get' for y in 'set' if x != 't' and y != 'e' ])

import decimal
print(0.28)
print(decimal.Decimal(0.28))
print(decimal.Decimal('5.30'))

import fractions
print(fractions.Fraction(2.5))
print(fractions.Fraction(5.2))
print(fractions.Fraction(3,5))
print(fractions.Fraction(1.3))
print(fractions.Fraction('3.7'))

l1 = ['A','B','C']
l2 = [1,2]
l1.extend(l2)
print(l1)
l1.append(l2)
print(l1)
set_a = {}
set_b = set()
print('set_a: ',type(set_a))
print('set_b: ',type(set_b))
set_c = {1,2,3,5,7}
set_c.add(10)
print(set_c)
set_d={'a','b','c','d','e','f'}
set_d.update(['g','a','h'],{'b','i'},(1,5))
print(set_d)
set_e=set([1,8,3,5,4,0])
set_f=set([2,3,7,0,1,10])
print('set_e.intersection(set_f): ',set_e.intersection(set_f))
print('set_e.union(set_f): ',set_e.union(set_f))
print('set_e.difference(set_f): ',set_e.difference(set_f))
print('set_e.symmetric_difference(set_f): ',set_e.symmetric_difference(set_f))

dict_a = dict([(1,'I'),(2,'II'),(3,'III'),(4,'IV'),(5,'V'),(6,'VI'),(7,'VII'),
               (8,'VIII'),(9,'IX'),(10,'X')])
print(type(dict_a))
print('Roman value for 5 ',dict_a[5])
dict_a.update({2:'2'})
print(dict_a)
dict_a.update({11:'XI'})
print(dict_a)


a_var = 5
b_var = 7
 
def outer_foo():
    global a_var
    a_var = 3
    b_var = 9
    def inner_foo():
        global a_var
        a_var = 4
        b_var = 8
        print('a_var inside inner_foo :', a_var)
        print('b_var inside inner_foo :', b_var)
    inner_foo()
    print('a_var inside outer_foo :', a_var)
    print('b_var inside outer_foo :', b_var)
     
outer_foo()
print('a_var outside all functions :', a_var)
print('b_var outside all functions :', b_var)

class BookStore:
    noOfBooks = 0
 
    def __init__(self, title, author):
        self.title = title
        self.author = author
        BookStore.noOfBooks += 1
 
    def bookInfo(self):
        print("Book title:", self.title)
        print("Book author:", self.author,"\n")
 
# Create a virtual book store
b1 = BookStore("Great Expectations", "Charles Dickens")
b2 = BookStore("War and Peace", "Leo Tolstoy")
b3 = BookStore("Middlemarch", "George Eliot")
 
# call member functions for each object
b1.bookInfo()
b2.bookInfo()
b3.bookInfo()

print("BookStore.noOfBooks:", BookStore.noOfBooks)


with open('test.txt', 'w', encoding='utf-8') as f:
    f.write("Test File..\n")
    f.write("Hello\n")
    f.write("Bye..")
    f.write("""Multi Line example...
Test multi line
3 lines in multi line..""")

with open('test.txt', 'r', encoding='utf-8') as f:
    content = f.readlines()

for line in content:
    print(line)

from shutil import copyfile
from sys import exit as system

source = input("Enter source file with full path: ")
target = input("Enter target file with full path: ")

# adding exception handling
try:
    copyfile(source, target)
except IOError as e:
    print("Unable to copy file. %s" % e)
    exit(1)
except:
    print("Unexpected error:", system.exc_info())
    exit(1)

print("\nFile copy done!\n")
