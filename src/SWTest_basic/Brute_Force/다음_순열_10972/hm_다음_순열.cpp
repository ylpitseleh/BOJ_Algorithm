/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_다음_순열.cpp                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/08 23:55:44 by hmin              #+#    #+#             */
/*   Updated: 2020/03/09 01:35:24 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
https://www.youtube.com/watch?v=mbOl9qPedDo&t=478s

1 3 5 4 4
1 4 3 4 5
1 3(idx1) 5 4 4(idx2)

// idx1: 뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인
// idx2: 다시 뒤에서부터 탐색하면서 idx1보다 큰 첫 번째 인덱스를 확인
// idx1과 idx2를 스왑
// idx1 + 1에서부터 끝까지 오름차순 정렬
 */

#include <iostream>
#include <vector>

using namespace std;

int len;
vector<int> nums;

void swap_num(int idx1, int idx2)
{
	int tmp;
	tmp = nums.at(idx1);
	nums.at(idx1) = nums.at(idx2);
	nums.at(idx2) = tmp;
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	// nums 채우기
	cin >> len;
	for (int i = 0; i < len; i++)
	{
		int tmp;
		cin >> tmp;
		nums.push_back(tmp);
	}

	// idx1: 뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인
	int idx1 = len - 2;
	while (idx1 >= 0 && nums.at(idx1) >= nums.at(idx1 + 1))
		idx1--;
	if (idx1 == -1)
	{
		cout << "-1";
		return (0);
	}

	// idx2: 다시 뒤에서부터 탐색하면서 idx1보다 큰 첫 번째 인덱스를 확인
	int idx2 = len - 1;
	while (nums.at(idx1) >= nums.at(idx2))
		idx2--;

	// idx1과 idx2를 스왑
	swap_num(idx1, idx2);

	// idx1 + 1에서부터 끝까지 오름차순 정렬
	int start = idx1 + 1;
	int end = len - 1;
	while (start < end)
		swap_num(start++, end--);

	// 결과값 출력
	for (int i = 0; i < len; i++)
		cout << nums.at(i) << " ";
	return (0);
}

/*
4
3 1 4 2
3 2 1 4
---
5
2 5 3 4 1
2 5 4 1 3
---
5
1 3 5 4 4
1 4 3 4 5
---
5
5 4 3 2 1
-1
 */
