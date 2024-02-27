package com.tupinamba.springbootwebsocket.repository;

import com.tupinamba.springbootwebsocket.model.ChatMessage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {
    List<ChatMessage> findAllByType(ChatMessage.MessageType chatMessage);
    @Override
    public default List<ChatMessage> findAll() {
        return null;
    }

    @Override
    public default List<ChatMessage> findAll(Sort sort) {
        return null;
    }

    @Override
    public default Page<ChatMessage> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public default List<ChatMessage> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public default long count() {
        return 0;
    }

    @Override
    public default void deleteById(Integer integer) {

    }

    @Override
    public default void delete(ChatMessage chatMessage) {

    }

    @Override
    public default void deleteAll(Iterable<? extends ChatMessage> iterable) {

    }

    @Override
    public default void deleteAll() {

    }

    @Override
    public default <S extends ChatMessage> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public default Optional<ChatMessage> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public default boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public default void flush() {

    }

    @Override
    public default <S extends ChatMessage> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public default void deleteInBatch(Iterable<ChatMessage> iterable) {

    }

    @Override
    public default void deleteAllInBatch() {

    }

    @Override
    public default ChatMessage getOne(Integer integer) {
        return null;
    }

    @Override
    public default <S extends ChatMessage> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public default <S extends ChatMessage> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public default <S extends ChatMessage> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public default<S extends ChatMessage> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public default<S extends ChatMessage> long count(Example<S> example) {
        return 0;
    }

    @Override
    public default<S extends ChatMessage> boolean exists(Example<S> example) {
        return false;
    }
}
