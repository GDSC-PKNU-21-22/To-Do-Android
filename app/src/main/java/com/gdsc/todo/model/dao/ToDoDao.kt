package com.gdsc.todo.model.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.gdsc.todo.model.entity.MyToDoList

@Dao
interface ToDoDao {
    // 테이블에 데이터 삽입
    @Insert(onConflict = REPLACE) // Insert 할 때 PrimaryKey가 겹치는 것이 있으면 덮어 쓴다는 의미
    fun insert(toDo: MyToDoList)

    // 테이블의 데이터 수정
    @Update
    fun update(toDo: MyToDoList)

    // 테이블의 데이터 삭제
    @Delete
    fun delete(toDo: MyToDoList)

    // 테이블의 모든 값 가져오기
    @Query("SELECT * FROM MyToDoList")
    fun getAll(): List<MyToDoList>

    // 'title'에 해당하는 투두를 삭제
    @Query("DELETE FROM MyToDoList WHERE title = :title")
    fun deleteToDoByTitle(title: String)
}