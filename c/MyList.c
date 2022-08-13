#include <stdio.h>
#include <stdlib.h>

typedef int ITEM;
typedef struct Node NODE;

struct Node {
	ITEM item;
	NODE* next;
};

/*
 * initList(void) returns a pointer dynamically allocated to a fake node
 */
NODE* initList(void) {
	NODE* tmp = (NODE*)malloc(sizeof(NODE));
    tmp->item = 0;
	tmp->next = NULL;
	return tmp;
}

int insert(NODE* list, int idx, ITEM item) {
	if (idx == 0 || list == NULL) return -1;
	
	int i = 0;

	while ((i < idx - 1) && (list != NULL)) {
		i++;
		list = list->next;
	}

	NODE* tmp = (NODE*)malloc(sizeof(NODE));
	tmp->next = list->next;
	tmp->item = item;
	list->next = tmp;
	
	return 0;
}

int printList(NODE* list) {
	NODE* curr = list;
	if (curr == NULL) return -1;

	printf("%d ", curr->item);
	curr = curr->next;
	while (curr != NULL) {
		printf("%d ", curr->item);
		curr = curr->next;
	}
	printf("\n");
}

int main() {
	NODE* list = initList();
	insert(list, 1, 1);
	insert(list, 2, 2);
    insert(list, 2, 10);
	printList(list);
	return 0;
}