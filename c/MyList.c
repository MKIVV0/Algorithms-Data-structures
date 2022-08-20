#include <stdio.h>
#include <stdlib.h>

typedef int ITEM;
typedef struct Node NODE;

struct Node {
	ITEM item;
	NODE* next;
};

/*
 * initList(item) returns a pointer dynamically allocated to a node
 */
NODE* initList(ITEM item) {
	NODE* tmp = (NODE*)malloc(sizeof(NODE));
    tmp->item = item;
	tmp->next = NULL;
	return tmp;
}

int isEmpty(NODE* list) {
	return list == NULL;
}

int length(NODE* list) {
	int n = 0;
	while (list != NULL) {
		n++;
		list = list->next;
	}
	return n;
}

// Corretto
int insert(NODE* list, int idx, ITEM item) {
	if (list == NULL) return -1;
	
	int i = 0;

	NODE* tmp = (NODE*)malloc(sizeof(NODE));
	if (idx == 0) {
		tmp->item = list->item;
		tmp->next = list->next;
		list->item = item;
		list->next = tmp;
	} else {
		while ((i < idx - 1) && (list != NULL)) {
			i++;
			list = list->next;
		}

		tmp->item = item;
		tmp->next = list->next;
		list->next = tmp;
	}
	
	return 0;
}

int delete(NODE* list, int idx) {
	if (list == NULL) return -1;

	if (idx == 0) {
		/*
		NODE* tmp = list;
		printf("Assigned %d to tmp\n", tmp->item);
		list = list->next;
		printf("Moved list pointer to the next node: %d\n", list->item);
		printf("Current value of node pointed from tmp: %d\n", tmp->item);
		free(tmp);*/
		NODE* tmp = list;
		list = list->next;
		free(tmp);
	} else {
		int i = 0;
		NODE* curr = list;
		while ((i < idx) && list != NULL) {
			i++;
			list = curr;
			curr = curr->next;
		}
		list->next = curr->next;
		free(curr);
	}

	return 0;
}

int printList(NODE* list) {
	NODE* curr = list;
	if (curr == NULL) {
		printf("NULL list");
		return -1;
	}

	printf("%d ", curr->item);
	curr = curr->next;
	while (curr != NULL) {
		printf("%d ", curr->item);
		curr = curr->next;
	}
	printf("\n");

	return 0;
}

int main() {
	
	NODE* list = initList(0);
	insert(list, 1, 1);
	insert(list, 2, 2);
    insert(list, 3, 10);
	insert(list, 0, -1);
	printList(list);
	printf("\nlist length: %d\n \nlist empty? %d\n", length(list), isEmpty(list));
	delete(list, 0);
	printf("\nPRINT POST DELETE\n");
	printList(list);

	printf("\n%d\n", list->next->next->item);

	//printf("\n%d\n", list->next->next->item);
	
	/* FUNZIONANTE (LA STESSA COSA LA FA IL METODO delete(), MA NON VA NIENTE)
	NODE* next = list;
	NODE* curr = list->next;
	free(next);
	printf("%d ", curr->item);
	printf("%d ", curr->next->item);
	printf("%d ", curr->next->next->item);
	printf("%d ", curr->next->next->next->item);
	*/

	printf("\n\n");

/*
	NODE* new = initList(10);
	printList(new);
	delete(new, 0);
	printList(new);
	*/
	return 0;
}